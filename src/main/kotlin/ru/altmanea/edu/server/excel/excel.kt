package ru.altmanea.edu.server.excel

import io.ktor.application.*
import io.ktor.response.*
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.util.CellRangeAddress
import ru.altmanea.edu.server.model.*
import ru.altmanea.edu.server.repo.scheduleRepo
import ru.altmanea.edu.server.repo.schedulesRepoTestData
import ru.altmanea.edu.server.repo.teacherRepo
import ru.altmanea.edu.server.repo.teacherRepoTest
import java.io.FileOutputStream

var fileSchedule = "src/main/resources/schedule.xls"
val book: Workbook = HSSFWorkbook()
val sheet: Sheet = book.createSheet("Расписание")  // создание нового листа в книг

fun patternSchedule() {
    //нумерация начинается с нуля
    val row = sheet.createRow(0) // создание новой строки в листе
    sheet.addMergedRegion(CellRangeAddress(0, 0, 0, 60)) //объединение ячеек
    row.createCell(0).apply {
        setCellValue("Расписание")
        cellStyle = styleAll
    }

    val row1 = sheet.createRow(1) // создание новой строки в листе
    sheet.addMergedRegion(CellRangeAddress(1, 1, 0, 29)) //объединение ячеек
    row1.createCell(0).apply {
        setCellValue("Нечетная")
        cellStyle = styleAll
    }
    sheet.addMergedRegion(CellRangeAddress(1, 3, 30, 30))
    row1.createCell(30).apply {
        setCellValue("Преподаватель")
        cellStyle = styleT
    }
    sheet.addMergedRegion(CellRangeAddress(1, 1, 31, 60)) //объединение ячеек
    row1.createCell(31).apply {
        setCellValue("Четная")
        cellStyle = styleAll
    }

    val row2 = sheet.createRow(2) // создание новой строки в листе
    val row3 = sheet.createRow(3)

    var i = 0
    listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб").map { day ->
        sheet.addMergedRegion(CellRangeAddress(2, 2, i, i + 4))
        sheet.addMergedRegion(CellRangeAddress(2, 2, 31 + i, 31 + i + 4))
        row2.createCell(i).apply {
            setCellValue(day)
            cellStyle = styleAll
        }
        row2.createCell(31 + i).apply {
            setCellValue(day)
            cellStyle = styleAll
        }
        var j = i
        listOf("08:00 - 09:35", "09:45 - 11:20", "11:30 - 13:05", "13:55 - 15:30", "15:40 - 17:15").map { number ->
            row3.createCell(j).apply {
                setCellValue(number)
                cellStyle = styleT
            }
            row3.createCell(31 + j).apply {
                setCellValue(number)
                cellStyle = styleT
            }
            sheet.autoSizeColumn(j)
            sheet.autoSizeColumn(31 + j)
            j++
        }
        i += 5
    }
}

//заполнение таблицы данными
fun filingScheduleExcel(){
    val teacher = teacherRepoTest
    var i = 3
    teacher.forEach { t ->
        i++
        val row = sheet.createRow(i)
        row.createCell(30).apply {
            setCellValue(t.fullname)
            cellStyle = styleAll
        }
        sheet.autoSizeColumn(30)

        val scheduleItem =
            schedulesRepoTestData.filter { it.Lesson.teachers.surname == t.surname}
        val data = scheduleItem.sortedWith(compareBy({ it.typeOfWeek}, { it.dayOfWeek}, {it.number}))

        data.forEach { item ->
            var j = 0
            if( item.typeOfWeek != TypeOfWeek.ODD) j = 31
            j += when(item.dayOfWeek) {
                DayOfWeek.Mon-> 0
                DayOfWeek.Tue -> 5
                DayOfWeek.Wed -> 10
                DayOfWeek.Thu -> 15
                DayOfWeek.Fri -> 20
                else -> 25
            }
            j += when(item.number) {
                ClassNumber.FIRST ->  0
                ClassNumber.SECOND->  1
                ClassNumber.THIRD ->  2
                ClassNumber.FOURTH->  3
                else ->  4
            }
            row.createCell(j).apply {
                setCellValue("${item.Lesson.type}\n${item.flow.groups}${item.flow.subgroup}\n${item.audience}")
                cellStyle = styleCell
            }
            sheet.autoSizeColumn(j)
        }
    }
}

fun writeIntoExcel() {
    patternSchedule()
    filingScheduleExcel()
    book.write(FileOutputStream(fileSchedule))
    book.close()
}