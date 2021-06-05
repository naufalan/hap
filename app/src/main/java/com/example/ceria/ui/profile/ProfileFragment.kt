package com.example.ceria.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ceria.R
import com.example.ceria.databinding.FragmentProfileBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<CollectibilityStatus>()
        list.add(
            CollectibilityStatus(
                "Lancar", "Hai Rama!\n" +
                        "Status Kolektibilitasmu lancar karena membayar tagihan tepat waktu. Pertahankan terus ya! :)"
            )
        )
        list.add(
            CollectibilityStatus(
                "Dalam Perhatian \n" +
                        "Khusus", "Hai Rama!\n" +
                        "Status Kolektibilitasmu dalam perhatian khusus karena telaht membayar tagihan. Segera bayar tagihan bulananmu ya."
            )
        )
        list.add(
            CollectibilityStatus(
                "Kurang Lancar", "Hai Rama!\n" +
                        "Status Kolektibilitasmu kurang lancar karena telat membayar tagihan. Segera bayar tagihan bulananmu ya."
            )
        )
        list.add(
            CollectibilityStatus(
                "Diragukan", "Hai Rama!\n" +
                        "Status Kolektibilitasmu diragukan karena telat membayar tagihan. Segera bayar tagihan bulananmu ya."
            )
        )
        list.add(
            CollectibilityStatus(
                "Macet", "Hai Rama!\n" +
                        "Status Kolektibilitasmu macet karena telat membayar tagihan. Segera bayar tagihan bulananmu ya."
            )
        )

        /*val listDialog = ArrayList<AlertDialog>()
        for (i in 0 until list.size) {
            listDialog.add(BaseDialog.collectibilityDialog(view, list[i].title, list[i].desc))
        }*/

        binding.apply {
            setClickListener {
                when (it.id) {

                    R.id.cl_logout_profile -> {
                        val bottomSheetFragment = BottomSheetLogoutFragment()
                        bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
                    }
                }
            }
        }
    }
}

data class CollectibilityStatus(var title: String, var desc: String)

class BottomSheetLogoutFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_logout, container, false)
    }
}