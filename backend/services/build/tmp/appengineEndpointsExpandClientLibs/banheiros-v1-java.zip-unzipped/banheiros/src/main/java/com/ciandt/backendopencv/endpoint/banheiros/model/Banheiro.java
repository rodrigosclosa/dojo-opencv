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
 * on 2016-12-15 at 14:47:44 UTC 
 * Modify at your own risk.
 */

package com.ciandt.backendopencv.endpoint.banheiros.model;

/**
 * Model definition for Banheiro.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the banheiros. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Banheiro extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String andar;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String descricao;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String predio;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean statusBanheiro;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String tipo;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAndar() {
    return andar;
  }

  /**
   * @param andar andar or {@code null} for none
   */
  public Banheiro setAndar(java.lang.String andar) {
    this.andar = andar;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescricao() {
    return descricao;
  }

  /**
   * @param descricao descricao or {@code null} for none
   */
  public Banheiro setDescricao(java.lang.String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Banheiro setId(java.lang.String id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPredio() {
    return predio;
  }

  /**
   * @param predio predio or {@code null} for none
   */
  public Banheiro setPredio(java.lang.String predio) {
    this.predio = predio;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getStatusBanheiro() {
    return statusBanheiro;
  }

  /**
   * @param statusBanheiro statusBanheiro or {@code null} for none
   */
  public Banheiro setStatusBanheiro(java.lang.Boolean statusBanheiro) {
    this.statusBanheiro = statusBanheiro;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getTipo() {
    return tipo;
  }

  /**
   * @param tipo tipo or {@code null} for none
   */
  public Banheiro setTipo(java.lang.String tipo) {
    this.tipo = tipo;
    return this;
  }

  @Override
  public Banheiro set(String fieldName, Object value) {
    return (Banheiro) super.set(fieldName, value);
  }

  @Override
  public Banheiro clone() {
    return (Banheiro) super.clone();
  }

}
