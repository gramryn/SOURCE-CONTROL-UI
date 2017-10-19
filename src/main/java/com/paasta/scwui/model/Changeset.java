/**
 * Copyright (c) 2010, Sebastian Sdorra
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of SCM-Manager; nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * http://bitbucket.org/sdorra/scm-manager
 *
 */
package com.paasta.scwui.model;

//~--- non-JDK imports --------------------------------------------------------

import com.paasta.scwui.common.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sonia.scm.repository.Modifications;
import sonia.scm.repository.Person;

import java.util.List;

//~--- JDK imports ------------------------------------------------------------

/**
 * Represents a changeset/commit of a repository.
 *
 */
@Getter
@Setter
@ToString
public class Changeset extends sonia.scm.repository.Changeset
{
  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs a new instance of changeset.
   *
   */
  public Changeset() {}
  public Changeset(sonia.scm.repository.Changeset changeset) {
    this.id = changeset.getId();
    this.date = changeset.getDate();
    this.setAuthor(changeset.getAuthor());
    this.description = changeset.getDescription();
    setDate(this.date);
  }

  public String getsDate() {
    return this.date > 0  ? DateUtil.convertLongToTime(this.date) : "";
  }

  //~--- fields ---------------------------------------------------------------

  /** The author of the changeset */
  private Person author;

  /** The name of the branches on which the changeset was committed. */
  private List<String> branches;

  /** The date when the changeset was committed */
  private Long date;

  /** The text of the changeset description */
  private String description;

  /** The changeset identification string */
  private String id;

  /** List of files changed by this changeset */
  private Modifications modifications;

  /** parent changeset ids */
  private List<String> parents;

  /** The tags associated with the changeset */
  private List<String> tags;


  /** The tags associated with the changeset */
  private String sDate;
}