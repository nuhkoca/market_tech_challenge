package com.techchallenge.core.util.executors

import javax.inject.Inject

class Executors @Inject constructor(
    executionThread: ExecutionThread,
    postExecutionThread: PostExecutionThread,
    computationThread: ComputationThread
) {
    val io = executionThread.scheduler
    val ui = postExecutionThread.scheduler
    val computation = computationThread.scheduler
}
