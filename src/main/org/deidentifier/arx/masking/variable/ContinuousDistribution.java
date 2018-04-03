/*
 * ARX: Powerful Data Anonymization
 * Copyright 2012 - 2018 Fabian Prasser and contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.deidentifier.arx.masking.variable;

import org.apache.commons.math3.distribution.AbstractRealDistribution;

/**
 * Implementation of a continuous distribution
 *
 * @author Fabian Kloos
 * @author Fabian Prasser
 * @author Karol Babioch
 */
public class ContinuousDistribution extends Distribution<Double> {

    private double min;
    private double max;
    private AbstractRealDistribution distribution;


    public ContinuousDistribution(double min, double max, double yLimit, AbstractRealDistribution distribution) {

        super(yLimit);

        this.min = min;
        this.max = max;
        this.distribution = distribution;

    }

    public ContinuousDistribution(double min, double max, AbstractRealDistribution distribution) {

        this(min, max, 0d, distribution);

    }

    @Override
    public Double getMinimum() {

        return min;

    }

    @Override
    public Double getMaximum() {

        return max;

    }

    @Override
    public double getValue(Double value) {

        return distribution.density(value);

    }

}
