package com.example.catexplorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.catexplorer.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!

    private val gatos = listOf(
        "🐱 Freddy",
        "🐱 Chica",
        "🐱 Bonnie",
        "🐱 Roxie",
        "🐱 Uvita"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListaBinding.inflate(inflater, container, false)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            gatos
        )

        binding.listaGatos.adapter = adapter

        // CLICK EN EL GATO
        binding.listaGatos.setOnItemClickListener { _, _, position, _ ->

            val gatoSeleccionado = gatos[position]

            val bundle = Bundle()
            bundle.putString("nombreGato", gatoSeleccionado)

            findNavController().navigate(
                R.id.action_listaFragment_to_detalleFragment,
                bundle
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}