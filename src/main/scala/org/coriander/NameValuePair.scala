/*
Copyright 2011 Ben Biddington

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.coriander

class NameValuePair(val name : String, val value : String) { }

object NameValuePair {
    def apply() : NameValuePairBuilder = new NameValuePairBuilder
    
    def _new : NameValuePairBuilder = new NameValuePairBuilder

    implicit def fromBuilder(builder : NameValuePairBuilder) : NameValuePair =
		builder.build
}