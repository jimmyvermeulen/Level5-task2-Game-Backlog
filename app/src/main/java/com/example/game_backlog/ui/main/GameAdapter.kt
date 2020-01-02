package com.example.game_backlog.ui.main
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.game_backlog.R
import com.example.game_backlog.model.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.util.*
import kotlin.time.days

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private lateinit var context : Context
    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvGameTitle: TextView = itemView.tvGameTitle
        private val tvPlatform: TextView = itemView.tvPlatforms
        private val tvDate: TextView = itemView.tvReleaseDate

        fun bind(game: Game) {
            var calendar : Calendar = Calendar.getInstance();
            calendar.time = game.releaseDate
            tvGameTitle.text = game.title
            tvPlatform.text = game.platform
            tvDate.text = context.getString(R.string.release_date, calendar.get(Calendar.DAY_OF_MONTH), calendar.getDisplayName(Calendar.MONTH , Calendar.LONG, Locale.getDefault()), calendar.get(Calendar.YEAR))
        }
    }
}