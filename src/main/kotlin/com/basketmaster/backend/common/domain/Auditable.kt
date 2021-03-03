package com.basketmaster.backend.common.domain

import java.time.Instant

interface Auditable {
    var creator: String
    var created: Instant
    var modifier: String
    var modified: Instant
}
