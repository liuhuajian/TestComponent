package com.lhj.function_mudule

import android.view.Menu
import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhj.function_mudule.databinding.ActivityFragmentTestBinding
import com.lhj.libbase.base.BaseActivity
import com.lhj.libcommon.RoutePathConstants

@Route(path = RoutePathConstants.MODULE_FUNCTION_SETTING_MAIN)
class FragmentTestActivity:BaseActivity() {
    override val bind by getBind<ActivityFragmentTestBinding>()

    override fun initView() {
        super.initView()
//        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                replaceFragment<FirstFragment>(R.id.fl_content)
                true
            }
            R.id.action_user ->{
                replaceFragment<SecondFragment>(R.id.fl_content)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}