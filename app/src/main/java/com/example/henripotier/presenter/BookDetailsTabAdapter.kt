package com.example.henripotier.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.henripotier.view.DetailsTabFragment
import com.example.henripotier.view.SynopsisTabFragment


class BookDetailsTabAdapter(
    fm: FragmentManager,
    private val presenter: BookDetailsActivityPresenter
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                SynopsisTabFragment(presenter)
            }
            else -> {
                DetailsTabFragment(presenter)
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Synopsis"
            else ->  {
                "Details"
            }
        }
    }
}