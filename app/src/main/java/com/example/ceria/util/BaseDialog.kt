package com.example.ceria.util

import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.ceria.databinding.DialogBaseBinding
import com.example.ceria.databinding.DialogBaseYesnoBinding
import com.example.ceria.databinding.DialogChangeNumberBinding
import com.example.ceria.databinding.DialogFailOtpBinding

class BaseDialog {
    companion object {
        fun simpleDialog(
            view: View,
            imageId: Int?,
            title: String,
            desc: String,
            buttonCaption: String,
            isCloseable: Boolean
        ): AlertDialog {
            val dialogView =
                DialogBaseBinding.inflate(LayoutInflater.from(view.context), null, false)
            val simpleDialog = AlertDialog.Builder(view.context).create()
            dialogView.apply {
                if (imageId != null) {
                    ivBaseDialog.setImageResource(imageId)
                    UtilFunction.stateViewVisible(ivBaseDialog)
                } else
                    UtilFunction.stateViewGone(ivBaseDialog)

                if (isCloseable) {
                    ivCloseBaseDialog.visibility = View.VISIBLE
                    ivCloseBaseDialog.setOnClickListener {
                        simpleDialog.dismiss()
                    }
                } else
                    ivCloseBaseDialog.visibility = View.GONE

                tvBaseDialog.text = title
                tvDescBaseDialog.text = desc
                btnBaseDialog.text = buttonCaption
            }

            simpleDialog.setView(dialogView.root)
            simpleDialog.setCancelable(false)
            return simpleDialog
        }

        fun yesnoDialog(
            view: View,
            imageId: Int?,
            title: String,
            desc: String,
            buttonYes: String,
            buttonNo: String
        ): AlertDialog {
            val dialogView =
                DialogBaseYesnoBinding.inflate(LayoutInflater.from(view.context), null, false)
            val yesnoDialog = AlertDialog.Builder(view.context).create()
            dialogView.apply {
                if (imageId != null) {
                    ivYesnoBaseDialog.setImageResource(imageId)
                    UtilFunction.stateViewVisible(ivYesnoBaseDialog)
                } else
                    UtilFunction.stateViewGone(ivYesnoBaseDialog)

                tvYesnoBaseDialog.text = title
                tvDescYesnoBaseDialog.text = desc
                btnYesYesnoBaseDialog.text = buttonYes
                btnNoYesnoBaseDialog.text = buttonNo
            }

            yesnoDialog.setView(dialogView.root)
            yesnoDialog.setCancelable(false)
            return yesnoDialog
        }

        fun failotpDialog(
            view: View,
            imageId: Int?,
            title: String,
            desc: String,
            isCloseable: Boolean
        ): AlertDialog {
            val dialogView =
                DialogFailOtpBinding.inflate(LayoutInflater.from(view.context), null, false)
            val failotpDialog = AlertDialog.Builder(view.context).create()
            dialogView.apply {
                if (imageId != null) {
                    ivFailOtp.setImageResource(imageId)
                    UtilFunction.stateViewVisible(ivFailOtp)
                } else
                    UtilFunction.stateViewGone(ivFailOtp)

                if (isCloseable) {
                    ivCloseFailOtp.visibility = View.VISIBLE
                    ivCloseFailOtp.setOnClickListener {
                        failotpDialog.dismiss()
                    }
                } else
                    ivCloseFailOtp.visibility = View.GONE

                tvFailOtp.text = title
                tvDescFailOtp.text = desc
            }
            failotpDialog.setView(dialogView.root)
            failotpDialog.setCancelable(false)
            return failotpDialog
        }
    }
}