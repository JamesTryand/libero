/*  ----------------------------------------------------------------<Prolog>-
    Name:       operator.java
    Title:      Expression evaluator object: operator stack

    Written:    96/06/26  Pascal Antonnaux <pascal@imatix.com>
    Revised:    96/07/14

    Copyright:  Copyright (c) 1991-1996 iMatix
    This program is free software; you can redistribute it and/or modify it
    under the terms of the GNU General Public License as published by the Free
    Software Foundation; either version 2 of the License, or (at your option)
    any later version. This program is distributed in the hope that it will be
    useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
    Public License for more details.  You should have received a copy of the
    GNU General Public License along with this program; if not, write to the
    Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 ------------------------------------------------------------------</Prolog>-*/

public class operator                   //  Object for operator stack
{
    public char token;                  //    Operator token
    public int  priority;               //    Relative priority

    // Constructor

    public void operator ()
    {
        token    = '\0';
        priority = 0;
    }
}
