package com.example.demoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.random.Random


class FirstFragment : Fragment() {

    private lateinit var months: Spinner
    private lateinit var graph: GraphView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        months = view.findViewById(R.id.months)
        graph = view.findViewById(R.id.graph)


        setData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    fun setData(){

        var dataSet = mutableListOf<DataPoint>(DataPoint(1.0, 3.5))
        for(i in 2..30){
            dataSet.add(DataPoint(i.toDouble(), Random.nextDouble()))
        }


        val series = LineGraphSeries(
            dataSet.toTypedArray()
        )

        graph.addSeries(series)
    }

}