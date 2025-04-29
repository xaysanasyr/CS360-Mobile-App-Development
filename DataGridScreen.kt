package com.example.cs360_projectone_inventoryapp_rx

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class InventoryItem(val name: String, var quantity: Int)

@SuppressLint("MutableCollectionMutableState")
@Composable
fun DataGridScreen() {
    var items by remember {
        mutableStateOf(
            mutableListOf(
                InventoryItem("Item A", 1),
                InventoryItem("Item B", 2),
                InventoryItem("Item C", 3)
            )
        )
    }
    var newItemName by remember { mutableStateOf("") }
    var newItemQuantity by remember { mutableStateOf("") }

    // State for editing
    var editingIndex by remember { androidx.compose.runtime.mutableIntStateOf(-1) } // -1 means no item is being edited
    var editedQuantity by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Inventory List", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Input Fields for adding new items
        OutlinedTextField(
            value = newItemName,
            onValueChange = { newItemName = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = newItemQuantity,
            onValueChange = { newItemQuantity = it },
            label = { Text("Quantity") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (newItemName.isNotBlank() && newItemQuantity.isNotBlank()) {
                    val quantity = newItemQuantity.toIntOrNull() ?: 0
                    items.add(InventoryItem(newItemName, quantity))
                    newItemName = ""
                    newItemQuantity = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Item")
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Item", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            Text("Quantity", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            Text("Actions", modifier = Modifier.weight(2f), style = MaterialTheme.typography.bodyLarge) // Increased weight
        }
        HorizontalDivider()

        // Data Grid
        LazyColumn {
            itemsIndexed(items) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(item.name, modifier = Modifier.weight(1f))
                    if (editingIndex == index) {
                        // Display TextField for editing
                        OutlinedTextField(
                            value = editedQuantity,
                            onValueChange = { editedQuantity = it },
                            modifier = Modifier.weight(1f),
                            label = { Text("New Quantity") }
                        )
                    } else {
                        // Display current quantity
                        Text(item.quantity.toString(), modifier = Modifier.weight(1f))
                    }
                    Row(modifier = Modifier.weight(2f), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        if (editingIndex == index) {
                            // Save and Cancel buttons during editing
                            Button(onClick = {
                                val newQuantity = editedQuantity.toIntOrNull()
                                if (newQuantity != null) {
                                    items[index].quantity = newQuantity
                                    items = items.toMutableList() // Trigger recomposition
                                }
                                editingIndex = -1
                                editedQuantity = ""
                            }) {
                                Text("Save")
                            }
                            Button(onClick = {
                                editingIndex = -1
                                editedQuantity = ""
                            }) {
                                Text("Cancel")
                            }
                        } else {
                            // Edit and Delete buttons
                            Button(onClick = {
                                editingIndex = index
                                editedQuantity = item.quantity.toString()
                            }) {
                                Text("Edit")
                            }
                            Button(onClick = {
                                items = items.toMutableList().also { it.removeAt(index) }
                            }) {
                                Text("Delete")
                            }
                        }
                    }
                }
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DataGridScreenPreview() {
    MaterialTheme {
        DataGridScreen()
    }
}