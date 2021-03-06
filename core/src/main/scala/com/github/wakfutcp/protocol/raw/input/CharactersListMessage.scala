package com.github.wakfutcp.protocol.raw.input

import java.nio.ByteBuffer

import com.github.wakfutcp.protocol.domain.Character
import com.github.wakfutcp.protocol.{InputMessage, InputMessageReader}


case class CharactersListMessage(characters: Array[Character]) extends InputMessage

object CharactersListMessage
  extends InputMessageReader[CharactersListMessage] {

  import com.github.wakfutcp.util.Extensions._

  def read(buf: ByteBuffer) = {
    val chars = Array.fill(buf.get.toInt) {
      Character.read(ByteBuffer.wrap(buf.getByteArray(buf.getShort.toInt)))
    }
    CharactersListMessage(chars)
  }
}
