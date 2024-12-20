//package com.example.hi.adapter
//
//
//import android.content.Context
//import android.graphics.Color
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.core.content.ContextCompat
//import androidx.lifecycle.lifecycleScope
//import androidx.recyclerview.widget.RecyclerView
//import com.example.hi.R
//
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//class OrderAdapter(
//    private val orderList: MutableList<Order>,
//    private val context: Context
//) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
//
//    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val orderName: TextView = itemView.findViewById(R.id.orderId)
//        val orderStatus: TextView = itemView.findViewById(R.id.orderStatus)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
//        return OrderViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
//        val order = orderList[position]
//
//        holder.orderName.text = "order number: ${order.idOrder}"
//        holder.orderStatus.text = "Status: ${order.track}"
//
//        when (order.track) {
//            "Shipped" -> holder.orderStatus.setTextColor(ContextCompat.getColor(context, R.color.green))
//            "Pending" -> holder.orderStatus.setTextColor(ContextCompat.getColor(context, R.color.red))
//        }
//    }
//
//    override fun getItemCount(): Int = orderList.size
//
//    //function to update the order statut
//    fun updateOrderStatus(orderId: Int, newStatus: String) {
//        val index = orderList.indexOfFirst { it.idOrder == orderId }
//        if (index != -1) {
//            orderList[index] = orderList[index].copy(track = newStatus)
//            notifyItemChanged(index)
//
//        }
//    }
//}