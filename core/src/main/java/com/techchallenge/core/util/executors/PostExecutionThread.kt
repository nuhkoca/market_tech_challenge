package com.techchallenge.core.util.executors

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}
