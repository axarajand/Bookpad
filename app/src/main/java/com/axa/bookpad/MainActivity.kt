package com.axa.bookpad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBooks: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        list.addAll(BooksData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBooks.adapter = listBookAdapter

        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                showSelectedBook(data)
            }
        })
    }

    private fun showSelectedBook(book: Book) {
        val moveIntent = Intent(this@MainActivity, DetailBook::class.java)
        moveIntent.putExtra(DetailBook.EXTRA_TITLE, book.title)
        moveIntent.putExtra(DetailBook.EXTRA_SERIES, book.series)
        moveIntent.putExtra(DetailBook.EXTRA_PUBLISHED, book.published_by)
        moveIntent.putExtra(DetailBook.EXTRA_RELEASE, book.release_date)
        moveIntent.putExtra(DetailBook.EXTRA_GENRE, book.genre)
        moveIntent.putExtra(DetailBook.EXTRA_PAGES, book.pages)
        moveIntent.putExtra(DetailBook.EXTRA_ISBN, book.isbn)
        moveIntent.putExtra(DetailBook.EXTRA_SINOPSIS, book.sinopsis)
        moveIntent.putExtra(DetailBook.EXTRA_PHOTO, book.photo)
        startActivity(moveIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val moveAbout = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(moveAbout)
            }
        }
    }

}
