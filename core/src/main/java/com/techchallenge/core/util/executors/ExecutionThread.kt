package com.techchallenge.core.util.executors

import io.reactivex.Scheduler

interface ExecutionThread {
    val scheduler: Scheduler
}
