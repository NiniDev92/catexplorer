package com.example.catexplorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.catexplorer.databinding.FragmentDetalleBinding
import androidx.navigation.fragment.findNavController

class DetalleFragment : Fragment() {

    private var _binding: FragmentDetalleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetalleBinding.inflate(inflater, container, false)

        val nombreGato = arguments?.getString("nombreGato")

        binding.tvNombreGato.text = nombreGato

        val descripcion = when (nombreGato) {

            "🐱 Freddy" -> "Freddy es un gato rubio muy juguetón y curioso."

            "🐱 Chica" -> "Chica es tranquila y le encanta dormir al sol."

            "🐱 Bonnie" -> "Bonnie es muy cariñosa y siempre busca mimos."

            "🐱 Roxie" -> "Roxie es valiente y le gusta explorar."

            "🐱 Uvita" -> "uvita supero la desnutricion y la anemia, para poder ser amada por siempre."

            else -> "Un adorable gatito."
        }

        binding.tvDescripcionGato.text = descripcion
        binding.btnContactar.setOnClickListener {

            findNavController().navigate(
                R.id.action_detalleFragment_to_contactoFragment
            )

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}