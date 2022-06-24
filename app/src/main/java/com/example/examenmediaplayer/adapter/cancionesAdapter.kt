package com.example.examenmediaplayer.adapter

import android.content.Context
import android.media.MediaMetadataRetriever
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.documentfile.provider.DocumentFile
import com.example.examenmediaplayer.R

class cancionesAdapter (context: Context, cancion :MutableList<DocumentFile>) :
    ArrayAdapter<DocumentFile>(context,0, cancion) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var rowView = inflater.inflate(R.layout.cancion_item, parent, false)

        val album = rowView.findViewById<TextView>(R.id.album)
        val nombre = rowView.findViewById<TextView>(R.id.cancion_nombre)
        val autor = rowView.findViewById<TextView>(R.id.autor)
        val cancion = getItem(position)
        val m_metaRetriever = android.media.MediaMetadataRetriever()

        // RECIBE UN CONTEXTO Y EL URI DE UN ARCHIVO
        m_metaRetriever.setDataSource(context, cancion?.uri)

        Log.e(
            "Titulo",
            m_metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE).toString()
        )


        Log.e(
            "Artista",
            m_metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST).toString()
        )

        Log.e(
            "Artista",
            m_metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM).toString()
        )



        nombre.setText(m_metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE))
        album.setText(m_metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM))
        autor.setText(m_metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST))

        return rowView
    }
}