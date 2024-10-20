package one.wabbit.hashing

import java.io.File
import java.io.FileInputStream
import java.nio.file.Path
import java.security.MessageDigest

private fun ByteArray.toHexString(): String {
    return joinToString("") { "%02x".format(it) }
}

fun Path.rawDigest(algorithm: String): ByteArray {
    val path = this
    val digest = java.security.MessageDigest.getInstance(algorithm)
    // stream the data
    FileInputStream(path.toFile()).use { stream ->
        val buffer = ByteArray(8192)
        var read = stream.read(buffer)
        while (read > 0) {
            digest.update(buffer, 0, read)
            read = stream.read(buffer)
        }
    }

    return digest.digest()
}

fun File.rawDigest(algorithm: String): ByteArray =
    this.toPath().rawDigest(algorithm)

fun String.rawDigest(algorithm: String): ByteArray {
    val digest = MessageDigest.getInstance(algorithm)
    return digest.digest(toByteArray())
}

fun ByteArray.rawDigest(algorithm: String): ByteArray {
    val digest = MessageDigest.getInstance(algorithm)
    return digest.digest(this)
}

fun Path.digest(algorithm: String): String = this.rawDigest(algorithm).toHexString()
fun File.digest(algorithm: String): String = this.rawDigest(algorithm).toHexString()
fun String.digest(algorithm: String): String = this.rawDigest(algorithm).toHexString()
fun ByteArray.digest(algorithm: String): String = this.rawDigest(algorithm).toHexString()

fun Path.sha1(): String = this.digest("SHA-1")
fun File.sha1(): String = this.toPath().digest("SHA-1")
fun String.sha1(): String = this.digest("SHA-1")
fun ByteArray.sha1(): String = this.digest("SHA-1")

fun Path.sha256(): String = this.digest("SHA-256")
fun File.sha256(): String = this.toPath().digest("SHA-256")
fun String.sha256(): String = this.digest("SHA-256")
fun ByteArray.sha256(): String = this.digest("SHA-256")

fun Path.sha512(): String = this.digest("SHA-512")
fun File.sha512(): String = this.toPath().digest("SHA-512")
fun String.sha512(): String = this.digest("SHA-512")
fun ByteArray.sha512(): String = this.digest("SHA-512")

fun Path.md5(): String = this.digest("MD5")
fun File.md5(): String = this.toPath().digest("MD5")
fun String.md5(): String = this.digest("MD5")
fun ByteArray.md5(): String = this.digest("MD5")
