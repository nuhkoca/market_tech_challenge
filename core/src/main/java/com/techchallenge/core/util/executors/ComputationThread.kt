package com.techchallenge.core.util.executors

import io.reactivex.Scheduler

interface ComputationThread {
    val scheduler: Scheduler
}
