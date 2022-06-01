package com.example.demoapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.random.Random


class FirstFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var spinner: Spinner
    private lateinit var graph: GraphView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val months = arrayOf<String>("January", "February", "March", "April", "May", "June", "July")
        spinner = view.findViewById(R.id.months)
        graph = view.findViewById(R.id.graph)



        spinner.adapter = ArrayAdapter<String>(requireContext().applicationContext, android.R.layout.simple_list_item_1, months)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(activity, months[p2] + " Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }





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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

}