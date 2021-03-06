//  Object used by calcul
//  Generated by LIBERO 2.11 on 14 Jul, 1996, 17:45.
//  Schema file used: lrschema.jav.

import java.awt.*;
import java.applet.*;
import java.net.*;
import java.util.*;
import java.io.*;


abstract public class calculi
{
    //- Variables used by dialog interpreter --------------------------------

    private static int
        _LR_event,                  //  Event for state transition
        _LR_state,                  //  Current dialog state
        _LR_savest,                 //  Saved dialog state
        _LR_index;                  //  Index of methods function

    public static int
        the_next_event,             //  Next event from module
        the_exception_event;        //  Exception event from module

    private static boolean
        exception_raised;           //  TRUE if exception raised


    //- Symbolic constants and event numbers --------------------------------

    private static int
        _LR_STOP            = 0xFFFF,
        _LR_NULL_EVENT      = -2;
    public static int
        _LR_STATE_after_init = 0,
        _LR_STATE_expecting_operand = 1,
        _LR_STATE_expecting_operator = 2,
        _LR_STATE_defaults  = 3,
        _LR_defaults_state  = 3,
        end_mark_event      = 0,
        error_event         = 1,
        exception_event     = 2,
        left_par_event      = 3,
        number_event        = 4,
        ok_event            = 5,
        operator_event      = 6,
        other_event         = 7,
        right_par_event     = 8,
        string_event        = 9,
        terminate_event     = -1;

    //- Static areas --------------------------------------------------------

    private static int _LR_nextst [][] = {
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,1,2,0,0,0,0,2 },
        { 2,0,0,0,0,0,1,0,2,0 },
        { 3,0,3,3,3,0,3,3,3,3 }
    };

    private static int _LR_action [][] = {
        { 0,2,0,0,0,1,0,0,0,0 },
        { 0,0,0,5,4,0,0,0,0,3 },
        { 7,0,0,0,0,0,6,0,8,0 },
        { 10,0,2,9,9,0,9,9,9,9 }
    };

    private static int _LR_vector [][] = {
        {0},
        {0,_LR_STOP},
        {6,_LR_STOP},
        {5,0,_LR_STOP},
        {3,0,_LR_STOP},
        {4,0,_LR_STOP},
        {8,4,0,_LR_STOP},
        {7,9,6,_LR_STOP},
        {7,10,0,_LR_STOP},
        {1,6,_LR_STOP},
        {2,6,_LR_STOP}
    };

    private static String _LR_mname [] = {
        "Get-Next-Token",
        "Signal-Invalid-Token",
        "Signal-Token-Missing",
        "Stack-The-Number",
        "Stack-The-Operator",
        "Stack-The-String",
        "Terminate-The-Program",
        "Unstack-All-Operators",
        "Unstack-Ge-Operators",
        "Unstack-If-End-Mark",
        "Unstack-If-Left-Par"
    };

    private static String _LR_sname [] = {
        "After-Init",
        "Expecting-Operand",
        "Expecting-Operator",
        "Defaults"
    };

    private static String _LR_ename [] = {
        "End-Mark-Event",
        "Error-Event",
        "Exception-Event",
        "Left-Par-Event",
        "Number-Event",
        "Ok-Event",
        "Operator-Event",
        "Other-Event",
        "Right-Par-Event",
        "String-Event"
    };

    abstract public void initialise_the_program ();
    abstract public void get_external_event ();
    abstract public void get_next_token ();
    abstract public void signal_invalid_token ();
    abstract public void signal_token_missing ();
    abstract public void stack_the_number ();
    abstract public void stack_the_operator ();
    abstract public void stack_the_string ();
    abstract public void terminate_the_program ();
    abstract public void unstack_all_operators ();
    abstract public void unstack_ge_operators ();
    abstract public void unstack_if_end_mark ();
    abstract public void unstack_if_left_par ();

    //- Dialog interpreter starts here --------------------------------------

    public int execute ()
    {
        int
            feedback = 0,
            index,
            next_module;

        _LR_state = 0;                  //  First state is always zero
        initialise_the_program ();
        while (the_next_event != terminate_event)
          {
            _LR_event = the_next_event;
            if (_LR_event >= 10 || _LR_event < 0)
              {
                String buffer;
                buffer  = "State " + _LR_state + " - event " + _LR_event;
                buffer += " is out of range";
                System.out.println (buffer);
                break;
              }
            _LR_savest = _LR_state;
            _LR_index  = _LR_action [_LR_state][_LR_event];
            //  If no action for this event, try the defaults state
            if (_LR_index == 0)
              {
                _LR_state = _LR_defaults_state;
                _LR_index = _LR_action [_LR_state][_LR_event];
              }
            System.out.println ( _LR_sname [_LR_state] + ':');
            System.out.println ("    (--) " + _LR_ename [_LR_event]);
            if (_LR_index == 0)
              {
                String buffer;
                buffer  = "State " + _LR_state + " - event " + _LR_event;
                buffer += " is not accepted";
                System.out.println (buffer);
                break;
              }
            the_next_event          = _LR_NULL_EVENT;
            the_exception_event     = _LR_NULL_EVENT;
            exception_raised        = false;
            next_module             = 0;

            for (;;)
              {
                index = _LR_vector [_LR_index][next_module];
                if ((index == _LR_STOP)
                || (exception_raised))
                break;
                System.out.println ("          + " + _LR_mname [index]);
                switch (index)
                  {
                    case 0: get_next_token (); break;
                    case 1: signal_invalid_token (); break;
                    case 2: signal_token_missing (); break;
                    case 3: stack_the_number (); break;
                    case 4: stack_the_operator (); break;
                    case 5: stack_the_string (); break;
                    case 6: terminate_the_program (); break;
                    case 7: unstack_all_operators (); break;
                    case 8: unstack_ge_operators (); break;
                    case 9: unstack_if_end_mark (); break;
                    case 10: unstack_if_left_par (); break;
                  }
                  next_module++;
              }
            if (exception_raised)
              {
                if (the_exception_event != _LR_NULL_EVENT)
                    _LR_event = the_exception_event;
                the_next_event = _LR_event;
                System.out.println ("    (=>) " + _LR_ename [_LR_event]);
              }
            else
                _LR_state = _LR_nextst [_LR_state][_LR_event];

            if (_LR_state == _LR_defaults_state)
                _LR_state = _LR_savest;
            if (the_next_event == _LR_NULL_EVENT)
              {
                get_external_event ();
                if (the_next_event == _LR_NULL_EVENT)
                  {
                    String buffer;
                    buffer  = "No event set after event " + _LR_event;
                    buffer += " in state " + _LR_state;
                    System.out.println (buffer);
                    break;
                  }
              }
          }
        return (feedback);
    }

    //- Standard dialog routines --------------------------------------------

    public void raise_exception (int event)
    {
        exception_raised = true;
        if (event >= 0)
            the_exception_event = event;
    }

}
