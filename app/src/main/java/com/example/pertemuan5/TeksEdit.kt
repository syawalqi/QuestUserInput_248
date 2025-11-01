package com.example.pertemuan5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusOptions: List<String> = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFF7E57C2))
                .padding(start = 20.dp, bottom = 10.dp),
            contentAlignment = Alignment.BottomStart
        ){
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ){
            Column (
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("NAMA LENGKAP", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.width(250.dp),
                    label = { Text(text = "Nama Lengkap") },
                    onValueChange = { textNama = it }
                )
                Text("JENIS KELAMIN", fontWeight = FontWeight.SemiBold)
                Row {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            Text(item)
                        }
                    }
                }
                Text("STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold)
                Row {
                    statusOptions.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                            Text(item)
                        }
                    }
                }
                Text("ALAMAT", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    modifier = Modifier.width(250.dp),
                    label = { Text(text = "Alamat Lengkap") },
                    onValueChange = { textAlamat = it }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    enabled = textAlamat.isNotEmpty(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    ),
                    shape = RoundedCornerShape(50.dp),
                    onClick = {
                        nama = textNama
                        jenis = textJK
                        alamat = textAlamat
                        status = textStatus
                    }
                ){
                    Text("Submit", color = Color.White, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))

                ElevatedCard(
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                ){
            Column(modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp)) {
                Text(text = "Nama   : $nama", color = Color.White)
                Text(text = "Gender : $jenis", color = Color.White)
                Text(text = "Alamat : $alamat", color = Color.White)
            }
        }
    }
}


