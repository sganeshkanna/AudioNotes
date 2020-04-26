package com.gk.audiorecorder.executor

import kotlinx.coroutines.*

var job = SupervisorJob()
val uiScope = CoroutineScope(Dispatchers.Main + job)
val bgDispatcher: CoroutineDispatcher = Dispatchers.IO
fun doInBackground(backgroundTask: () -> Any, onCompletion: (Any) -> Unit) = uiScope.launch {
    val result = withContext(bgDispatcher) {
        // background thread
        backgroundTask.invoke()
    }
    onCompletion.invoke(result)
}