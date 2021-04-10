package com.example.ceria.ui.home.apply.initial_form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ceria.R
import com.example.ceria.databinding.FragmentApplyThirdBinding
import com.example.ceria.util.BaseDialog

class ApplyThirdFragment : Fragment() {
    private lateinit var viewModel: ApplyThirdViewModel
    private lateinit var binding: FragmentApplyThirdBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplyThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarApplyThird.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            btnApplyThird.setOnClickListener { view ->
                initiateDialog(view)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplyThirdViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun unregisteredCompanyDialog(): AlertDialog {
        val factory = LayoutInflater.from(requireContext())
        val dialogView = factory.inflate(R.layout.dialog_unregistered_company, null)
        val unregisteredCompanyDialog = AlertDialog.Builder(requireContext()).create()
        unregisteredCompanyDialog.setView(dialogView)
        unregisteredCompanyDialog.setCancelable(false)
        return unregisteredCompanyDialog
    }

    private fun initiateDialog(view: View) {
        val inactiveAccountDialog = BaseDialog.simpleDialog(
                view,
                R.drawable.ic_card_not_found,
                "Ups, No Rekeningmu\nTidak Aktif",
                "Gunakan rekening simpananmu\nyang masih aktif",
                getString(R.string.ganti_no_rekening),
                true
        )

        val recheckDataDialog = BaseDialog.simpleDialog(
                view,
                R.drawable.ic_card_failed_requirements,
                getString(R.string.gagal),
                "Cek kembali data yang kamu\nmasukkan telah sesuai.",
                getString(R.string.cek_ulang_nomor),
                true
        )

        val thirdTimeTryingDialog = BaseDialog.simpleDialog(
                view,
                R.drawable.ic_card_failed_requirements,
                getString(R.string.gagal),
                "Kamu telah mencapai batasan untuk \nmengisi ID-mu sebanyak 3 kali. Coba \nkembali request setelah 30 menit.",
                getString(R.string.kembali_ke_home),
                true
        )

        val ktpNotFoundDialog = BaseDialog.simpleDialog(
                view,
                R.drawable.ic_card_failed_requirements,
                getString(R.string.gagal),
                "No E-KTP yang anda input tidak \nsesuai. Coba cek lagi.",
                getString(R.string.cek_ulang_nomor),
                true
        )

        val unregisteredCompany = unregisteredCompanyDialog()

        val messageSentDialog = BaseDialog.simpleDialog(
                view,
                R.drawable.ic_message_sent,
                getString(R.string.pesan_terkirim),
                "Terima kasih telah mengirimkan \nnama dan lokasi perusahaan kamu! \nKami akan berusaha agar ceria \nsegera hadir untuk kamu.",
                "",
                true
        )

        val requirementsFulfilledDialog = BaseDialog.simpleDialog(
                view,
                R.drawable.ic_congratulation,
                getString(R.string.sukseess),
                "Kamu memenuhi persyaratan \nmengajukan limit",
                getString(R.string.lanjutkan_pengajuan),
                false
        )

        inactiveAccountDialog.show()
        inactiveAccountDialog.findViewById<Button>(R.id.btn_base_dialog)?.setOnClickListener {
            recheckDataDialog.show()
            recheckDataDialog.findViewById<Button>(R.id.btn_base_dialog)?.setOnClickListener {
                thirdTimeTryingDialog.show()
                thirdTimeTryingDialog.findViewById<Button>(R.id.btn_base_dialog)
                    ?.setOnClickListener {
                        view.findNavController()
                            .navigate(R.id.action_applyThirdFragment_to_nav_graph)
                        thirdTimeTryingDialog.dismiss()
                    }
                thirdTimeTryingDialog.findViewById<ImageView>(R.id.iv_base_dialog)
                    ?.setOnClickListener {
                        ktpNotFoundDialog.show()
                        ktpNotFoundDialog.findViewById<Button>(R.id.btn_base_dialog)
                            ?.setOnClickListener {
                                unregisteredCompany.show()
                                unregisteredCompany.findViewById<Button>(R.id.btn_unregistered_company)
                                    ?.setOnClickListener {
                                        messageSentDialog.show()
                                        messageSentDialog.findViewById<Button>(R.id.btn_base_dialog)?.visibility =
                                            View.GONE
                                        messageSentDialog.findViewById<ImageView>(R.id.iv_base_dialog)
                                            ?.setOnClickListener {
                                                requirementsFulfilledDialog.show()
                                                requirementsFulfilledDialog.findViewById<Button>(R.id.btn_base_dialog)
                                                    ?.setOnClickListener {
                                                        view.findNavController()
                                                            .navigate(R.id.action_applyThirdFragment_to_applyFourthFragment)
                                                        requirementsFulfilledDialog.dismiss()
                                                    }
                                                messageSentDialog.dismiss()
                                            }
                                        unregisteredCompany.dismiss()
                        }
                        ktpNotFoundDialog.dismiss()
                    }
                    thirdTimeTryingDialog.dismiss()
                }
                recheckDataDialog.dismiss()
            }
            inactiveAccountDialog.dismiss()
        }
    }
}