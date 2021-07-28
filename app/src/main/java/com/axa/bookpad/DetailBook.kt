package com.axa.bookpad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailBook : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_SERIES = "extra_series"
        const val EXTRA_PUBLISHED = "extra_published"
        const val EXTRA_RELEASE = "extra_release"
        const val EXTRA_GENRE = "extra_genre"
        const val EXTRA_PAGES = "extra_pages"
        const val EXTRA_SINOPSIS = "extra_sinopsis"
        const val EXTRA_ISBN = "extra_isbn"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)

        val bookTitle: TextView = findViewById(R.id.book_title)
        val bookSeries: TextView = findViewById(R.id.book_series)
        val bookPublished: TextView = findViewById(R.id.book_published)
        val bookRealese: TextView = findViewById(R.id.book_realese)
        val bookGenre: TextView = findViewById(R.id.book_genre)
        val bookPages: TextView = findViewById(R.id.book_pages)
        val bookISBN: TextView = findViewById(R.id.book_isbn)
        val bookSinopsis: TextView = findViewById(R.id.book_sinopsis)
        val bookPhoto: ImageView = findViewById(R.id.book_photo)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val series = intent.getStringExtra(EXTRA_SERIES)
        val published = intent.getStringExtra(EXTRA_PUBLISHED)
        val realese = intent.getStringExtra(EXTRA_RELEASE)
        val genre = intent.getStringExtra(EXTRA_GENRE)
        val pages = intent.getIntExtra(EXTRA_PAGES, 0)
        val isbn = intent.getStringExtra(EXTRA_ISBN)
        val sinopsis = intent.getStringExtra(EXTRA_SINOPSIS)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        bookTitle.text = title
        bookSeries.text = series
        bookPublished.text = published
        bookRealese.text = realese
        bookGenre.text = genre
        bookPages.text = pages.toString()
        bookISBN.text = isbn
        bookSinopsis.text = sinopsis
        bookPhoto.setImageResource(photo)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.back, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.back -> {
                val moveAbout = Intent(this@DetailBook, MainActivity::class.java)
                startActivity(moveAbout)
            }
        }
    }

}
