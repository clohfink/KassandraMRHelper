/**
 * Copyright 2013 Knewton
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.knewton.mapreduce.io;

import com.knewton.mapreduce.SSTableRecordReader;
import com.knewton.mapreduce.SSTableRowRecordReader;

import org.apache.cassandra.io.sstable.SSTableIdentityIterator;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Input format that instantiates an sstable row record reader.
 *
 */
public class SSTableRowInputFormat extends SSTableInputFormat<ByteBuffer,
        SSTableIdentityIterator> {

    /**
     * Create a new record reader for this <code>split<code>.
     *
     * @param split
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public SSTableRecordReader<ByteBuffer, SSTableIdentityIterator>
            createRecordReader(InputSplit split, TaskAttemptContext context)
                    throws IOException, InterruptedException {
        return new SSTableRowRecordReader();
    }
}
