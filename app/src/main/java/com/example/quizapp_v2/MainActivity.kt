package com.example.quizapp_v2

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var ArrayQuestion: ArrayList<Question> = ArrayList<Question>()
    private var isItem: Int = 0
    private var isQuestion: Question? = null
    private var listSizeQuestion: Int = 0
    private var sess :Int = 0
    private var accountName : Any? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDatDefaul()
        accountName  = intent.getStringExtra(Constants.ACCOUNT_NAME)
    }

    /**
     * Set defaul check box
     * @param {TextView} _textView
     * @return {void}
     */
    fun defaultOption(_textView: TextView) {
        _textView.setBackgroundResource(R.drawable.nonebacgr)
    }
    /**
     * Set defaul check box
     * @param {TextView} _textView
     * @param {Int} _drawable
     * @return {void}
     */
    fun selectedOption(_textView: TextView, _drawable: Int) {
        _textView.setBackgroundResource(_drawable as Int)
    }

    /**
     * Set question folow is index
     * @param {int} _inedx
     * @return {void}
     */
    fun setItemQuestion(_inedx: Int) {
        // get question folow is index
        isQuestion = ArrayQuestion.get(_inedx)
        // set item to view
        // question
        findViewById<TextView>(R.id.question).text = isQuestion?.question.toString()
        // img
        findViewById<ImageView>(R.id.imageView).setImageResource(isQuestion!!.img)
        //Set view item data defaul
        findViewById<TextView>(R.id.textView6).text = isQuestion?.listAnswer?.get(0).toString()
        findViewById<TextView>(R.id.textView7).text = isQuestion?.listAnswer?.get(1).toString()
        findViewById<TextView>(R.id.textView8).text = isQuestion?.listAnswer?.get(2).toString()
        findViewById<TextView>(R.id.textView9).text = isQuestion?.listAnswer?.get(3).toString()

    }

    /**
     * Set data defaul on  display
     * @return {void}
     */
    fun setDatDefaul() {
        //Craete Data createData
        this.createData()
        //get Size list question
        listSizeQuestion = ArrayQuestion.size
        //Set lent item ProgressBar
        var progressBar = findViewById(R.id.progressBar) as ProgressBar
        progressBar.max = listSizeQuestion
        progressBar.progress = 0
        //Set text size
        var sizeStatus = findViewById(R.id.sizeStatus) as TextView
        sizeStatus.text =
            sizeStatus.text.toString().substring(0, sizeStatus.text.toString().indexOf("/") + 1)
                .plus(listSizeQuestion)

        sizeStatus.text = isItem.toString().plus(
            sizeStatus.text.toString().substring(
                sizeStatus.text.toString().indexOf("/"),
                sizeStatus.text.toString().length
            )
        )
        // set item view 1
        setItemQuestion(0)
        //set bacgrount dafaul
        defaultOption(findViewById(R.id.textView6))
        defaultOption(findViewById(R.id.textView7))
        defaultOption(findViewById(R.id.textView8))
        defaultOption(findViewById(R.id.textView9))

    }

    /**
     * Create data defaul list question
     * @return{void}
     */
    fun createData() {
        var question: String = "What coutry does this flag belog to ?"
        //1
        ArrayQuestion.add(
            Question(
                1,
                question,
                "Argentina",
                listOf("Argentina", "Viet Nam", "US", "Italia"),
                R.drawable.ic_flag_of_argentina
            )
        )
        //2
        ArrayQuestion.add(
            Question(
                2,
                question,
                "Australia",
                listOf("Australia", "Viet Nam", "US", "Italia"),
                R.drawable.ic_flag_of_australia
            )
        )
        //3
        ArrayQuestion.add(
            Question(
                3,
                question,
                "Belgium",
                listOf("Belgium", "Viet Nam", "US", "Italia"),
                R.drawable.ic_flag_of_belgium
            )
        )
        //4
        ArrayQuestion.add(
            Question(
                4,
                question,
                "Brasil",
                listOf("Argentina", "Brasil", "US", "Italia"),
                R.drawable.ic_flag_of_brazil
            )
        )
        //5
        ArrayQuestion.add(
            Question(
                5,
                question,
                "Denmark",
                listOf("Argentina", "Viet Nam", "Denmark", "Italia"),
                R.drawable.ic_flag_of_denmark
            )
        )
        //6
        ArrayQuestion.add(
            Question(
                6,
                question,
                "Fiji",
                listOf("Argentina", "Viet Nam", "US", "Fiji"),
                R.drawable.ic_flag_of_fiji
            )
        )
        //7
        ArrayQuestion.add(
            Question(
                7,
                question,
                "Germany",
                listOf("Germany", "Viet Nam", "US", "Italia"),
                R.drawable.ic_flag_of_germany
            )
        )
        //8
        ArrayQuestion.add(
            Question(
                8,
                question,
                "India",
                listOf("Argentina", "India", "US", "Italia"),
                R.drawable.ic_flag_of_india
            )
        )
        //9
        ArrayQuestion.add(
            Question(
                9,
                question,
                "Kuwait",
                listOf("Argentina", "Viet Nam", "Kuwait", "Italia"),
                R.drawable.ic_flag_of_kuwait
            )
        ) //10
        ArrayQuestion.add(
            Question(
                10,
                question,
                "Zealand",
                listOf("Argentina", "Viet Nam", "US", "Zealand"),
                R.drawable.ic_flag_of_new_zealand
            )
        )
    }

    /**
     * Chang next question
     * @param {View} view
     * @return {void}
     */
    fun changNext(view: View) {
        //next question
        if (isItem < listSizeQuestion)
            setItemQuestion(isItem++)
        defaultOption(findViewById(R.id.textView6))
        defaultOption(findViewById(R.id.textView7))
        defaultOption(findViewById(R.id.textView8))
        defaultOption(findViewById(R.id.textView9))
        //
        var progressBar = findViewById(R.id.progressBar) as ProgressBar
        progressBar.progress = isItem
        //
        var sizeStatus = findViewById(R.id.sizeStatus) as TextView
        sizeStatus.text = isItem.toString().plus(
            sizeStatus.text.toString().substring(
                sizeStatus.text.toString().indexOf("/"),
                sizeStatus.text.toString().length
            )
        )
        if (isItem >= listSizeQuestion){
            var intent = Intent(this,ResultActivity::class.java)
            intent.putExtra(Constants.ACCOUNT_NAME,accountName.toString())
            startActivity(intent)
            finish();
        }

    }

    fun changItem(_view: View) {
        var itemCheck: TextView = _view as TextView
        if(itemCheck.text.toString().compareTo(isQuestion!!.answer)==0){
            selectedOption(itemCheck,R.drawable.sess)
            sess ++;
        }else{
            selectedOption(itemCheck,R.drawable.error)
            if(findViewById<TextView>(R.id.textView6).text.toString().compareTo(isQuestion!!.answer)==0){
                selectedOption(findViewById<TextView>(R.id.textView6),R.drawable.sess)
            }
            if(findViewById<TextView>(R.id.textView7).text.toString().compareTo(isQuestion!!.answer)==0){
                selectedOption(findViewById<TextView>(R.id.textView7),R.drawable.sess)
            }
            if(findViewById<TextView>(R.id.textView8).text.toString().compareTo(isQuestion!!.answer)==0){
                selectedOption(findViewById<TextView>(R.id.textView8),R.drawable.sess)
            }
            if(findViewById<TextView>(R.id.textView9).text.toString().compareTo(isQuestion!!.answer)==0){
                selectedOption(findViewById<TextView>(R.id.textView9),R.drawable.sess)
            }
        }
    }
}