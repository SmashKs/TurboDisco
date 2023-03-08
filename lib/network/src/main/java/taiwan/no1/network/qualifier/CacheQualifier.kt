package taiwan.no1.network.qualifier

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

internal class CacheQualifier(override val value: QualifierValue = "Cache Qualifier") : Qualifier
