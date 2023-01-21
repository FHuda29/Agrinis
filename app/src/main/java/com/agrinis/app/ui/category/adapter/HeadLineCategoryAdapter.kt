package com.agrinis.app.ui.category.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.agrinis.app.R
import com.agrinis.app.data.models.Article
import com.agrinis.app.databinding.NewsCategoryItemsBinding
import com.agrinis.app.ui.category.activity.DetaiViewActivity
import com.agrinis.app.ui.category.fragment.MainFragmentDirections
import com.agrinis.app.util.callbacks.NewsTitleClickListener
import com.agrinis.app.util.helper.CustomTabHelper

class HeadLineCategoryAdapter(private val articles: List<Article>,private val context: Context): RecyclerView.Adapter<HeadLineCategoryAdapter.ArticleHolder>() {
    private var customTabHelper: CustomTabHelper = CustomTabHelper()
    class ArticleHolder(val view: NewsCategoryItemsBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val binder = DataBindingUtil.inflate<NewsCategoryItemsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.news_category_items,
            parent,false
        )
        return ArticleHolder(binder)
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.view.article = articles[position]
        holder.view.clickListener = clickListener
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    private val clickListener = object: NewsTitleClickListener {
        override fun onClickItem(view: View, itemData: Article) {
            /*val navigation = MainFragmentDirections.toDetailFragment(itemData.url)
            Navigation.findNavController(view).navigate(navigation)*/
            openDetailNews(itemData.url)
        }

    }

    private fun openDetailNews(url:String){
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
        builder.addDefaultShareMenuItem()
        val anotherCustomTab = CustomTabsIntent.Builder().build()
        val requestCode = 100
        val intent = anotherCustomTab.intent
        intent.setData(Uri.parse(url))
        /*val pendingIntent = PendingIntent.getActivity(context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT)*/

        //builder.addMenuItem("Menu Items", pendingIntent)
        builder.setShowTitle(true)
        builder.setStartAnimations(context, android.R.anim.fade_in, android.R.anim.fade_out)
        builder.setExitAnimations(context, android.R.anim.fade_in, android.R.anim.fade_out)

        val customTabsIntent = builder.build()
        val packageName = customTabHelper.getPackageNameToUse(context, url)
        if (packageName == null) {
            val intentOpenUri = Intent(context, DetaiViewActivity::class.java)
            intentOpenUri.putExtra(DetaiViewActivity.EXTRA_URL, Uri.parse(url).toString())
            context.startActivity(intentOpenUri)
        } else {
            customTabsIntent.intent.setPackage(packageName)
            customTabsIntent.launchUrl(context, Uri.parse(url))
        }
    }
}