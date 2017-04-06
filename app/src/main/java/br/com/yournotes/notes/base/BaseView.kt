package br.com.yournotes.notes.base

/**
 * Created by thalissonestrela Team on 4/6/17.
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(msg: String)
}