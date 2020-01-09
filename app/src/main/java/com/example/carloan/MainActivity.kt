package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        //Getting input data from the user
        val car_price = editTextCarPrice.text.toString().toInt()
        val down_payment = editTextDownPayment.text.toString().toInt()
        val loan_period = editTextLoanPeriod.text.toString().toInt()
        val interest_rate = editTextInterestRate.text.toString().toInt()

        val loan = car_price - down_payment
        val interest = loan *interest_rate * loan_period
        val monthlyRepayment = (loan + interest)/loan_period/12

        //textViewLoan.text = loan.toString()
        textViewLoan.text = getString(R.string.loan) + ": ${loan}"
        //textViewInterest.text = interest.toString()
        textViewInterest.text = getString(R.string.interest) + ": ${interest}"
        //textViewMonthlyRepayment.text = monthlyRepayment.toString()
        textViewMonthlyRepayment.text = getString(R.string.monthly_repayment) + ": ${monthlyRepayment}"

    }

    fun resetInput(view: View){
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextInterestRate.text.clear()
        editTextLoanPeriod.text.clear()

        textViewLoan.text = getString(R.string.loan)
        textViewInterest.text = getString(R.string.interest)
        textViewMonthlyRepayment.text = getString(R.string.monthly_repayment)
    }
}
