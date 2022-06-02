package ru.altmanea.edu.server.excel

import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.VerticalAlignment

val styleAll: CellStyle = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
}
val styleT: CellStyle = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
    rotation = 90
}

val styleCell: CellStyle = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
    val font = book.createFont().apply{
        fontHeight = 140
    }
    setFont(font)
    wrapText = true
}

val styleCellLec: CellStyle = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
    val font = book.createFont().apply{
        fontHeight = 140
        bold = true
    }
    setFont(font)
    wrapText = true
}