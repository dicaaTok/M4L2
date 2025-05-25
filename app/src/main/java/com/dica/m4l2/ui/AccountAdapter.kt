package com.dica.m4l2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dica.m4l2.R
import com.dica.m4l2.data.model.Account
import com.dica.m4l2.databinding.ItemBinding
import retrofit2.http.DELETE


class AccountAdapter(
    val onDELETE: (String) -> Unit,
    val onChange: (Account) -> Unit,
    val onStatusToggle: (String, Boolean) -> Unit
) : RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {
    inner class AccountViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Account) = with(itemView) {
            binding.tvName.text = item.name
            binding.tvBalance.text = "${item.balance}${item.currency}"
            binding.btnDelete.setOnClickListener({
                item.id?.let {
                    onDELETE(it)
                }
            })
            binding.btnChange.setOnClickListener({
                onChange(item)
            })
            binding.swhActive.setOnCheckedChangeListener(null)
            binding.swhActive.isChecked=item.isActive
            binding.swhActive.setOnCheckedChangeListener { buttonView,isChecked->
                item.id?.let {
                    onStatusToggle(it,isChecked)
                }
            }

        }
    }

    private val items = mutableListOf<Account>()

    fun submitList(data: List<Account>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccountAdapter.AccountViewHolder {
        return AccountViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: AccountAdapter.AccountViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}