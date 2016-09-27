/*
 * Copyright © 2015 ZTE and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.highstreet.technologies.odl.app.spectrum.impl.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olinchy on 16-9-14.
 */
public class Successful<T> extends Result<T>
{
    public Successful(List<T> mo)
    {
        this.mo = mo;
    }

     List<T> mo;

    public Successful(ArrayList<T> lst, Maybe<Integer> transId) {super();}

    @Override
    public long getResult()
    {
        return 0;
    }

    @Override
    public boolean isSuccess()
    {
        return true;
    }

    @Override
    public List<T> getMo()
    {
        return mo;
    }

    @Override
    public Maybe<Integer> getTransId()
    {
        return null;
    }
}
