/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-10-17 16:43:55 UTC)
 * on 2016-12-13 at 14:40:08 UTC 
 * Modify at your own risk.
 */

package com.ciandt.backendopencv.endpoint.status.model;

/**
 * Model definition for Status.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the status. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Status extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime data;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String idBanheiro;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean manutencao;

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getData() {
    return data;
  }

  /**
   * @param data data or {@code null} for none
   */
  public Status setData(com.google.api.client.util.DateTime data) {
    this.data = data;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Status setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getIdBanheiro() {
    return idBanheiro;
  }

  /**
   * @param idBanheiro idBanheiro or {@code null} for none
   */
  public Status setIdBanheiro(java.lang.String idBanheiro) {
    this.idBanheiro = idBanheiro;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getManutencao() {
    return manutencao;
  }

  /**
   * @param manutencao manutencao or {@code null} for none
   */
  public Status setManutencao(java.lang.Boolean manutencao) {
    this.manutencao = manutencao;
    return this;
  }

  @Override
  public Status set(String fieldName, Object value) {
    return (Status) super.set(fieldName, value);
  }

  @Override
  public Status clone() {
    return (Status) super.clone();
  }

}