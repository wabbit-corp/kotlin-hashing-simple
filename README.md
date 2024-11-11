# Kotlin Simple Hashing

This project consists of utilities that calculate cryptographic hash values using algorithms like MD5, SHA-1, SHA-256, and SHA-512 for different Kotlin data types.

## Installation

Add the following dependency to your project:

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.wabbit-corp:kotlin-hashing-simple:1.0.0")
}
```

## Usage

```kotlin
import java.nio.file.Paths
import one.wabbit.hashing.*

fun main() {
    val path = Paths.get("/path/to/your/file")
    val fileHash = path.sha256()  // Compute SHA-256 hash of a file
    println("SHA-256: $fileHash")

    val text = "Hello, World!"
    val textHash = text.md5()  // Compute MD5 hash of a string
    println("MD5: $textHash")

    val byteArray = byteArrayOf(0x01, 0x02, 0x03)
    val byteArrayHash = byteArray.sha512()  // Compute SHA-512 hash of a byte array
    println("SHA-512: $byteArrayHash")
}
```

## Licensing

This project is licensed under the GNU Affero General Public License v3.0 (AGPL-3.0) for open-source use.

For commercial use, please contact Wabbit Consulting Corporation (at wabbit@wabbit.one) for licensing terms.

## Contributing

Before we can accept your contributions, we kindly ask you to agree to our Contributor License Agreement (CLA).
