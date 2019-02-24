package ru.geogram.redmadrobottimetracker.app.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.geogram.domain.model.days.SingleDayInfo
import ru.geogram.redmadrobottimetracker.app.presentation.fragment.DaysTasksFragment

class ViewPagerTaskAdapter(val fragmentManager: FragmentManager, val daysList: ArrayList<SingleDayInfo>) :
    FragmentPagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        val day = daysList.get(position)
        return DaysTasksFragment(day)
    }

    override fun getCount(): Int {
        return daysList.size
    }

    fun addDays(days: ArrayList<SingleDayInfo>) {
        daysList.clear()
        daysList.addAll(days)
        notifyDataSetChanged()
    }
}