package com.example.todo_simplified.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.todo_simplified.data.Task
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.window.Dialog
import java.text.SimpleDateFormat
import java.util.*

/**
 * Simple readable date formatter for deadlines.
 */
private fun formatDate(timestamp: Long?): String {
    if (timestamp == null) return ""
    val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    return sdf.format(Date(timestamp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(viewModel: TaskViewModel) {
    val tasks by viewModel.allTasks.observeAsState(emptyList())
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    // Holds chosen deadline before adding the task
    var selectedDeadline by remember { mutableStateOf<Long?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Sanket's Simple MVVM Todo") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {

                TextField(
                    value = textState,
                    onValueChange = { textState = it },
                    label = { Text("New Task") },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Button to pick deadline
                Button(onClick = { showDatePicker = true }) {
                    Text("Date")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = {
                    if (textState.text.isNotEmpty()) {
                        viewModel.addTask(textState.text, selectedDeadline)
                        textState = TextFieldValue("")
                        selectedDeadline = null
                    }
                }) {
                    Text("Add")
                }
            }

            // Show the chosen date under the input, if any
            selectedDeadline?.let {
                Text(
                    text = "Selected deadline: ${formatDate(it)}",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onDelete = { viewModel.deleteTask(task) },
                        onToggle = { viewModel.toggleDone(task) }
                    )
                }
            }
        }
    }

    // Pop-up date picker
    if (showDatePicker) {
        DatePickerDialog(
            onDateSelected = {
                selectedDeadline = it
                showDatePicker = false
            },
            onDismiss = { showDatePicker = false }
        )
    }
}

@Composable
fun TaskItem(task: Task, onDelete: () -> Unit, onToggle: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Checkbox(
                        checked = task.isDone,
                        onCheckedChange = { onToggle() }
                    )

                    Text(
                        text = task.title,
                        textDecoration = if (task.isDone)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None
                    )
                }

                TextButton(onClick = onDelete) { Text("Delete") }
            }

            // Show deadline if the task has one
            task.deadline?.let {
                Text(
                    text = "Due: ${formatDate(it)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog(
    onDateSelected: (Long) -> Unit,
    onDismiss: () -> Unit
) {
    val state = rememberDatePickerState()

    Dialog(onDismissRequest = onDismiss) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Column(modifier = Modifier.padding(16.dp)) {
                DatePicker(state = state)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    TextButton(onClick = {
                        state.selectedDateMillis?.let(onDateSelected)
                        onDismiss()
                    }) {
                        Text("OK")
                    }
                }
            }
        }
    }
}