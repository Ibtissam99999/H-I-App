import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hi.R
import com.example.hi.data.JewelryItem

class FavoriteProductAdapter(
    private val favoriteItems: List<JewelryItem>,
    private val onItemClick: (JewelryItem) -> Unit
) : RecyclerView.Adapter<FavoriteProductAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_product, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoriteItems[position]
        holder.bind(item, onItemClick)
    }

    override fun getItemCount(): Int = favoriteItems.size

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.product_image)
        private val productName: TextView = itemView.findViewById(R.id.product_name)
        private val productPrice: TextView = itemView.findViewById(R.id.product_price)

        fun bind(item: JewelryItem, onItemClick: (JewelryItem) -> Unit) {
            // Affichage des données
            productName.text = item.title
            productPrice.text = item.price
            productImage.setImageResource(item.imageRes)

            // Ajout du gestionnaire d'événements pour le clic
            itemView.setOnClickListener {
                onItemClick(item)
            }


        }
    }
}
