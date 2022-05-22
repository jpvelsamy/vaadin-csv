/*
 * Copyright 2021 by Stefan Uebe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aj.view.table;

import com.vaadin.flow.component.Tag;

/**
 * Represents the table header cell element ({@code <th>}). Is contained in a table row.
 *
 * @see TableRow
 *
 * @author Stefan Uebe
 */
@Tag("th")
public class TableHeaderCell extends TableCell implements HasScope {
    public static String SCOPE_COLUMN = "col";
    public static String SCOPE_ROW = "row";
    public static String SCOPE_ROW_GROUP = "rowgroup";
    public static String SCOPE_COLUMN_GROUP = "colgroup";
}
