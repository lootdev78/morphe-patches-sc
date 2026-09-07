/**
 * Copyright 2026 Hoo-dles
 * https://github.com/hoo-dles/morphe-patches
 */

package hoodles.morphe.patches.soundcloud.home

import app.morphe.patcher.Fingerprint

object SDUIToHomeResultsFingerprint : Fingerprint(
    definingClass = "Lcom/soundcloud/android/sdui/domain/SDUIRepository\$toHomeResults\$1;",
    name = "invokeSuspend",
    returnType = "Ljava/lang/Object;"
)
