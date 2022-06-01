package com.example.demoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry


class SecondFragment : Fragment() {

    private lateinit var pie : AnyChartView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pie = view.findViewById<AnyChartView>(R.id.pieChart)

        setChart()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


    fun setChart(){

        val pieChart = AnyChart.pie()

        val dataList: MutableList<DataEntry> = ArrayList()
        dataList.add(ValueDataEntry("Data 1", 40))
        dataList.add(ValueDataEntry("Data 2", 30))
        dataList.add(ValueDataEntry("Data 3", 20))
        dataList.add(ValueDataEntry("Data 4", 10))

        pieChart.data(dataList)
        pie.setChart(pieChart)
    }

}