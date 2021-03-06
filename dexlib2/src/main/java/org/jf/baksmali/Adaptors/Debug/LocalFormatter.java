/*
 * Copyright 2013, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jf.baksmali.Adaptors.Debug;




import org.jf.baksmali.Adaptors.ReferenceFormatter;
import org.jf.util.IndentingWriter;

import java.io.IOException;

public class LocalFormatter {
    /**
     * Writes out the given local info
     * <p>
     * The written string will be something like:
     * <p>
     * "localVar":Ljava/lang/String;, "SomeSignature"
     * "localVar":Ljava/lang/String;
     * "localVar":V, "SomeSignature"
     * null:Ljava/lang/String;, "SomeSignature"
     * null:V, "SomeSignature"
     * <p>
     * One of name, type or signature must be non-null
     */
    public static void writeLocal(IndentingWriter writer, String name, String type,
                                  String signature) throws IOException {
        if (name != null) {
            ReferenceFormatter.writeStringReference(writer, name);
        } else {
            writer.write("null");
        }
        writer.write(':');
        if (type != null) {
            writer.write(type);
        } else {
            writer.write("V");
        }
        if (signature != null) {
            writer.write(", ");
            ReferenceFormatter.writeStringReference(writer, signature);
        }
    }
}
