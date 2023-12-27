package uz.turgunboyevjurabek.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.turgunboyevjurabek.weatherapp.databinding.ItemRvHourlyBinding
import uz.turgunboyevjurabek.weatherapp.model.madels.hourly.Hourly

class HourlyRvAdapter:RecyclerView.Adapter<HourlyRvAdapter.Vh>() {
    private val list=ArrayList<Hourly>()
    inner class Vh(val itemRvHourlyBinding: ItemRvHourlyBinding):ViewHolder(itemRvHourlyBinding.root){
        fun onBind(apiHourly: Hourly,position: Int){
            // gradusni aniqlash uchun
            val c=apiHourly.main.tempMax-273.0
            itemRvHourlyBinding.thtC.text=c.toInt().toString()+"°"
            // vaqtlarni aniqlash va formatlash
            val dateAndTime=apiHourly.dtTxt
            val date=dateAndTime.substring(0,10)
            val time=dateAndTime.substring(11,16)
            itemRvHourlyBinding.thtDate.text=date
            itemRvHourlyBinding.thtTime.text=time

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvHourlyBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return 3
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    fun updateData(newDate:ArrayList<Hourly>){
        if (list.isNotEmpty()){
            list.clear()
        }
        list.addAll(newDate)
    }

}