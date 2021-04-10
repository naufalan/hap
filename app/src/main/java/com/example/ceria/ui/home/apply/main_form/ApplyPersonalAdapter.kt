package com.example.ceria.ui.home.apply.main_form

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ceria.R


class ApplyPersonalAdapter(private val list: ArrayList<Int>, private val context: Context) :
        RecyclerView.Adapter<ApplyPersonalAdapter.CustomViewHolder>() {
    private val listCard = ArrayList<String>()
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): CustomViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.list_card_apply_personal, viewGroup, false
        )

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(
        viewHolder: CustomViewHolder,
        position: Int
    ) {
        viewHolder.apply {
            val spinnerAdapter = ArrayAdapter<String>(
                    context,
                    R.layout.support_simple_spinner_dropdown_item,
                    context.resources.getStringArray(R.array.credit_card)
            )
            spinner.adapter = spinnerAdapter
//            spinner.onItemSelectedListener = spinnerSelectedListener
            if (list.size == 1) {
                addItem(position)
            } else if (list.size > 1) {
                if (position == itemCount - 1) {
                    addItem(position)
                } else {
                    removeItem(position)
                }
            }
        }
    }

//    private val spinnerSelectedListener = object : AdapterView.OnItemSelectedListener {
//        override fun onNothingSelected(parent: AdapterView<*>?) {
//
//        }
//
//        override fun onItemSelected(
//            parent: AdapterView<*>?,
//            view: View?,
//            position: Int,
//            id: Long
//        ) {
//            listCard.add(parent.)
//        }
//
//    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CustomViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        val ivAdd = itemView.findViewById(R.id.iv_list_apply_personal) as ImageView
        val spinner =
                itemView.findViewById(R.id.spinner_list_apply_personal) as androidx.appcompat.widget.AppCompatSpinner

        fun removeItem(position: Int) {
            ivAdd.setImageResource(R.drawable.ic_cc_minus)
            ivAdd.setOnClickListener {
                list.remove(list[position])
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, list.size);
            }
        }

        fun addItem(position: Int) {
            ivAdd.setImageResource(R.drawable.ic_cc_plus)
            ivAdd.setOnClickListener {
                list.add(list[position] + 1)
                notifyDataSetChanged()
            }
        }

    }
}
