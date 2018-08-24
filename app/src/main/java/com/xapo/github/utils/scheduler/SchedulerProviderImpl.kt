package com.xapo.github.utils.scheduler



import javax.inject.Inject

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

class SchedulerProviderImpl @Inject
constructor() : SchedulerProvider {

    override fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun backgroundThread(): Scheduler {
        return Schedulers.io()
    }

    override fun computationThread(): Scheduler {
        return Schedulers.from(Executors.newSingleThreadExecutor())
    }

}
